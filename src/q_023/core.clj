(ns q-023.core
  (:gen-class)
  (:require [numbers.perfect :refer [abundant?]]))

(defn abundant-numbers [start end]
  (->> (range start (inc end))
       (filter abundant?)
       (into #{})))

(defn sum-of-2-abundant-numbers? [abundant-numbers n]
  (some #(contains? abundant-numbers (- n %)) abundant-numbers))

(defn -main
  "Non-abundant sums"
  [& args]
  (let [limit 28123
        abundants (abundant-numbers 1 limit)]

    (def answer (->> (range 1 limit)
                     (remove #(sum-of-2-abundant-numbers? abundants %))
                     (apply +)))
    (println answer)
    answer))
