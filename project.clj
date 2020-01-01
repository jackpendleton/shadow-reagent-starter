(defproject my-shadow-reagent "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [compojure "1.6.1"]
                 [ring "1.8.0"]
                 [ring-server "0.5.0"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [yogthos/config "1.1.6"]]

  :plugins [[lein-environ "1.1.0"]]

;   :ring {:handler my-shadow-reagent.handler/app
;          :uberwar-name "my-shadow-reagent.war"}

  :min-lein-version "2.5.0"
  :uberjar-name "my-shadow-reagent.jar"
  :main ^:skip-aot my-shadow-reagent.server
  :clean-targets ^{:protect false}
  [:target-path "target/%s"]

  :source-paths ["src/clj" "src/cljc"]
  :resource-paths ["resources"]

  :profiles {:dev {:dependencies [[cider/piggieback "0.4.2"]
                                  [binaryage/devtools "0.9.11"]
                                  [ring/ring-mock "0.4.0"]
                                  [ring/ring-devel "1.8.0"]
                                  [prone "2019-07-08"]
                                  [figwheel-sidecar "0.5.19"]
                                  [nrepl "0.6.0"]
                                  [thheller/shadow-cljs "2.8.37"]]
                   :repl-options {:init-ns my-shadow-reagent.repl}
                   :source-paths ["env/dev/clj"]
                   :plugins [[lein-figwheel "0.5.19"]]
                   :env {:dev true}}

             :uberjar {:aot :all}})
