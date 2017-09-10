(ns q-030.core
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]
            [strings.conversion :refer [number-to-digits]]))

(defn digits-power-sum [power number]
  (->> (number-to-digits number)
       (map #(math/expt % power))
       (apply +)))

(defn narcissistic-numbers [max power]
  ; Skip the single digit numbers because they 'aren't a sum'.
  (->> (range 10 (inc max))
       (filter #(= % (digits-power-sum power %)))))

; https://en.wikipedia.org/wiki/Narcissistic_number
(defn -main
  "Digit fifth powers"
  [& args]
  (let [power 5
        ; Max is because 6 digits is the maximum length before the sum of digit powers stops growing fast enough to
        ; reach the digit count required, and 6*(9^5) = 354294.
        ;
        ; The highest output for any individual digit is 9^5 = 59049, and a brief experiment shows that only numbers
        ; up to 6 digits are possible, as the largest possible 7 digit number score is 7*(9^5) = 413343, which is
        ; only 6 digits long.
        max (* 6 (math/expt 9 power))
        answer (->> (narcissistic-numbers max power)
                    (apply +))]
    (println answer)
    answer))