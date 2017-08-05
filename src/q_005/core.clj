(ns q-005.core
  (:gen-class)
  (:require [numbers.primes :refer [prime-factors-grouped]]
            [clojure.math.numeric-tower :refer [expt]]))

(defn greatest-shared-prime-factors [numbers]
  (apply (partial merge-with max) (map prime-factors-grouped numbers)))

(defn keys-expt-values [[key value]]
  (expt key value))

(defn least-common-multiple [numbers]
  (reduce * (map keys-expt-values (greatest-shared-prime-factors numbers))))

(defn -main
  "Smallest multiple"
  [& args]
  (def answer (least-common-multiple (range 2 20)))
  (println answer)
  answer)
