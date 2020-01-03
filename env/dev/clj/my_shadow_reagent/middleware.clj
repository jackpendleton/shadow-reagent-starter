(ns my-shadow-reagent.middleware
  (:require
   [prone.middleware :refer [wrap-exceptions]]
   [ring.middleware.file :refer [wrap-file]]
   [ring.middleware.params :refer [wrap-params]]
   [ring.middleware.reload :refer [wrap-reload]]
   [ring.middleware.resource :refer [wrap-resource]]
   [ring.middleware.file-info :refer [wrap-file-info]]
   [ring.middleware.content-type :refer [wrap-content-type]]
   [ring.middleware.defaults :refer [site-defaults wrap-defaults]]))

(defn apply-middleware [handler]
  (-> handler
      (wrap-resource "public")
      (wrap-defaults site-defaults)
      (wrap-file "resources")
      (wrap-file-info)
      (wrap-content-type)
      (wrap-params)
      (wrap-exceptions)
      (wrap-reload)))
