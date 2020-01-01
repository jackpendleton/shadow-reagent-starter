(ns my-shadow-reagent.core
  (:require [reagent.core :as r :refer [atom]]
            [my-shadow-reagent.util :refer [msg]]))

(defonce app-state (atom {:text "Hello World!"}))

(defn hello-world []
  [:div
   [:h1 (:text @app-state)]
   [:h3 (str "Code Sharing: [" (msg) "]")]])

(defn start []
  (r/render-component [hello-world]
                      (. js/document (getElementById "app")))
  (js/console.log ">>> Start!"))

(defn ^:export init! []
  ;; init! is called once in index.html when the page loads
  (start)
  (js/console.log ">>> Init!"))

(defn stop []
  ;; stop is called before any code is reloaded
  ;; this is controlled by :before-load in the config
  (js/console.log ">>> Stop!"))