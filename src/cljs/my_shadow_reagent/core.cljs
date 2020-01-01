(ns my-shadow-reagent.core
  (:require [reagent.core :as r :refer [atom]]
            [my-shadow-reagent.util :refer [msg]]))

(defonce app-state (atom {:text "Hello World!"}))

(defn hello-world []
  [:div
   [:h1 (:text @app-state)]
   [:h3 (str "Code Sharing: [" (msg) "]")]])

(defn start []
  ;; see :after-load in the shadow-cljs config
  (r/render [hello-world]
            (.getElementById js/document "app"))
  (js/console.log ">>> Start!"))

(defn stop []
  ;; see :before-load in the shadow-cljs config
  (js/console.log ">>> Stop!"))

(defn ^:export init! []
  ;; init! is called once in index.html on page load
  (js/console.log ">>> Init!")
  (start))