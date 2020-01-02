(ns rest-api.handler
  (:require [compojure.route :as route]
            [compojure.core :refer [defroutes GET]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [ring.util.response :refer [resource-response]]
            [clojure.string :as str]
            [clojure.data.json :as json])
  (:gen-class))

(def people-collection (atom []))

; GET /hello-world
(defn hello-world [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Hello World!"})

; GET /hello-name
(defn hello-name [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (->
             (println (str "Query params: " (:params req)))
             (str "Hello " (:name (:params req))))})

; GET /people
(defn people-handler [req]
  {:status  200
   :headers {"Content-Type" "text/json"}
   :body    (str (json/write-str @people-collection))})

; POST /people/add
(defn add-person [first last]
  (swap! people-collection conj {:first (str/capitalize first)
                                 :last  (str/capitalize last)}))

(defn getparam
  "get the param specified by pname from the req map"
  [req pname] (get (:params req) pname))

(defn add-person-handler [req]
  {:status  200
   :headers {"Content-Type" "text/json"}
   :body    (-> (let [p (partial getparam req)]
                  (str (json/write-str (add-person (p :first) (p :last))))))})

; Routes
(defroutes routes
  (GET "/" []
    (resource-response "public/index.html"))
  (GET "/hello" [] hello-world)
  (GET "/hello-name" [] hello-name)
  (GET "/people" [] people-handler)
  (GET "/people/add" [] add-person-handler)
  (route/not-found "Error, page not found!"))

(def app
  (-> routes
      (wrap-resource "public")
      (wrap-defaults site-defaults)))
