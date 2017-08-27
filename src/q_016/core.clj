(ns q-016.core
  (:gen-class)
  (:require [clojure.math.numeric-tower :refer [expt]]
            [strings.conversion :refer [string-to-digits]]))

(defn -main
  "Power digit sum"
  [& args]
  (def answer (apply + (string-to-digits (str (expt 2 1000)))))
  (println answer)
  answer)
