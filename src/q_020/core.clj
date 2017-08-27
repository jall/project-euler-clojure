(ns q-020.core
  (:gen-class)
  (:require [numbers.factorial :refer [factorial]]
            [strings.conversion :refer [string-to-digits]]))

(defn -main
  "Factorial digit sum"
  [& args]
  (def answer (->> (factorial 100)
                   (str)
                   (string-to-digits)
                   (apply +)))
  (println answer)
  answer)
