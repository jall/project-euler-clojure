(ns q-015.core
  (:gen-class)
  (:require [numbers.combinatorics :refer [binomial-coefficient]]))

(defn -main
  "Lattice paths"
  [& args]
  (def answer (binomial-coefficient 40 20))
  (println answer)
  answer)
