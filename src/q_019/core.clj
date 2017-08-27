(ns q-019.core
  (:gen-class)
  (:require [clj-time.core :refer [date-time]]
            [clj-time.predicates :refer [sunday?]]))

(defn -main
  "Counting Sundays"
  [& args]
  (def answer (->> (for [year (range 1901 2001) month (range 1 13)]
                     (sunday? (date-time year month 1)))
                   (filter true?)
                   (count)))
  (println answer)
  answer)
