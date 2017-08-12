(ns q-009.core
  (:gen-class)
  (:require [numbers.pythagorean-triple :refer [pythagorean-triples]]))

(defn -main
  "Special Pythagorean triplet"
  [& args]
  (def answer (->> (pythagorean-triples 10 50)
                   (filter #(= 1000 (apply + %)))
                   (first)
                   (apply *)))
  (println answer)
  answer)
