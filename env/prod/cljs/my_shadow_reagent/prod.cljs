(ns my-shadow-reagent.prod
  (:require [my-shadow-reagent.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
