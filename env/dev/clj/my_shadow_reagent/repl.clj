(ns my-shadow-reagent.repl
  (:require [my-shadow-reagent.handler :refer [app]]
            figwheel-sidecar.repl-api
            [ring.server.standalone :refer [serve]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [ring.middleware.file :refer [wrap-file]]))

(defonce server (atom nil))

(defn get-handler []
  (-> #'app
      (wrap-file "resources")
      (wrap-file-info)))

(defn start-server
  [& [port]]
  (let [port (if port (Integer/parseInt port) 3000)]
    (reset! server
            (serve (get-handler)
                   {:port port
                    :auto-reload? true
                    :join? false}))
    (println (str "Site available at http://localhost:" port))))

(defn stop-server []
  (.stop @server)
  (reset! server nil))
