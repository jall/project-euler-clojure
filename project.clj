(defproject project-euler-clojure "0.1.0-SNAPSHOT"
  :description "Project Euler solutions"
  :url "https://github.com/jall/project-euler-clojure"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/math.numeric-tower "0.0.4"]
                 [org.clojure/math.combinatorics "0.1.4"]]
  :main ^:skip-aot project-euler-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
