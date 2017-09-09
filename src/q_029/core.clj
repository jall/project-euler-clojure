(ns q-029.core
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]))

(defn -main
  "Distinct powers"
  [& args]
  (let [answer (->> (for [a (range 2 101)
                          b (range 2 101)]
                      (math/expt a b))
                    (into #{})
                    (count))]
    (println answer)
    answer))
