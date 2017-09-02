(ns q-025.core
  (:gen-class)
  (:require [numbers.fibonacci :refer [fibonacci]]))

(defn -main
  "1000-digit Fibonacci number"
  [& args]
  (let [answer (->> (fibonacci 1 1)
                    (map-indexed (fn [index item] [index item]))
                    (some (fn [[index item]]
                            (if (= 1000 (count (str item))) index)))
                    ; Increment because vector is zero indexed Fibonacci seq is 1 indexed
                    (inc))]
    (println answer)
    answer))
