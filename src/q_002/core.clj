(ns q-002.core
  (:gen-class)
  (:require [numbers.fibonacci :refer [fibonacci]]))

(defn even-fibonacci [] (filter even? (fibonacci)))

(defn -main
  "Even Fibonacci numbers"
  [& args]
  (def answer (apply +' (take-while #(<= % 4000000) (even-fibonacci))))
  (println answer)
  answer)
