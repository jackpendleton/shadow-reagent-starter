(ns my-shadow-reagent.repl
  (:require
   [my-shadow-reagent.handler :refer [app]]
   [my-shadow-reagent.middleware :refer [apply-middleware]]
   [figwheel-sidecar.repl-api]
   [ring.server.standalone :refer [serve]]))

(defonce server (atom nil))

(defn get-handler [] (apply-middleware #'app))

(defn start-server [& [port]]
  (let [port (if port (Integer/parseInt port) 3000)]
    (reset! server
            (serve (get-handler)
                   {:port port
                    :auto-reload? true
                    :join? false}))
    (println (str ">>> Site available at http://localhost:" port))))

(defn stop-server []
  (.stop @server)
  (reset! server nil))
