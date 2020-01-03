(ns my-shadow-reagent.server
  (:require
   [my-shadow-reagent.handler :refer [app]]
   [my-shadow-reagent.middleware :refer [apply-middleware]]
   [config.core :refer [env]]
   [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(defn -main [& args]
  (let [port (or (env :port) 3000)]
    (run-jetty (apply-middleware app) {:port port :join? false})))
