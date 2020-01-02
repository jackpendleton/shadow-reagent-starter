(defproject my-shadow-reagent "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.5.0"
  :uberjar-name "my-shadow-reagent.jar"
  :main ^:skip-aot my-shadow-reagent.server
  :clean-targets ^{:protect false}
  [:target-path "target/%s"]
  :source-paths ["src/clj" "src/cljc" "src/cljs"]
  :resource-paths ["resources"]

  :plugins [[lein-environ "1.1.0"]]

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/data.json "0.2.7"]
                 [compojure "1.6.1"]
                 [reagent "0.9.0-rc3"]
                 [reagent-utils "0.3.3"]
                 [ring "1.8.0"]
                 [ring-server "0.5.0"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [yogthos/config "1.1.6"]]

  :profiles {:dev {:dependencies [[thheller/shadow-cljs "2.8.37"]
                                  [binaryage/devtools "0.9.11"]
                                  [figwheel-sidecar "0.5.19"]
                                  [ring/ring-devel "1.8.0"]
                                  [ring/ring-mock "0.4.0"]
                                  [prone "2019-07-08"]
                                  [nrepl "0.6.0"]]
                   :repl-options {:init-ns my-shadow-reagent.repl}
                   :source-paths ["env/dev/clj"]
                   :env {:dev true}}

             :uberjar {:aot :all}})
