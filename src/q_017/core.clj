(ns q-017.core
  (:gen-class)
  (:require [clojure.string :as str]))

; Stolen from clojure-humanize, until my PR to fix 1000 goes through
; https://github.com/trhura/clojure-humanize/pull/21

(def ^:private numap
  {0 "",1 "one",2 "two",3 "three",4 "four",5 "five",
   6 "six",7 "seven",8 "eight",9 "nine",10 "ten",
   11 "eleven",12 "twelve",13 "thirteen",14 "fourteen",
   15 "fifteen",16 "sixteen",17 "seventeen",18 "eighteen",
   19 "nineteen",20 "twenty",30 "thirty",40 "forty",
   50 "fifty",60 "sixty",70 "seventy",80 "eighty",90 "ninety"})

(defn numberword
  "Takes a number and return a full written string form. For example,
   23237897 will be written as \"twenty-three million two hundred and
   thirty-seven thousand eight hundred and ninety-seven\".  "
  [num]

  ;; special case for zero
  (if (zero? num)
    "zero"

    (let [digitcnt (int (java.lang.Math/log10 num))
          divisible? (fn [num div] (zero? (rem num div)))
          n-digit (fn [num n] (Character/getNumericValue (.charAt (str num) n)))] ;; TODO rename

      (cond
        ;; handle million part
        (>= digitcnt 6)    (if (divisible? num 1000000)
                             (str/join " " [(numberword (int (/ num 1000000)))
                                            "million"])
                             (str/join " " [(numberword (int (/ num 1000000)))
                                            "million"
                                            (numberword (rem num 1000000))]))

        ;; handle thousand part
        (>= digitcnt 3)    (if (divisible? num 1000)
                             (str/join " " [(numberword (int (/ num 1000)))
                                            "thousand"])
                             (str/join " " [(numberword (int (/ num 1000)))
                                            "thousand"
                                            (numberword (rem num 1000))]))

        ;; handle hundred part
        (>= digitcnt 2)    (if (divisible? num 100)
                             (str/join " " [(numap (int (/ num 100)))
                                            "hundred"])
                             (str/join " " [(numap (int (/ num 100)))
                                            "hundred"
                                            "and"
                                            (numberword (rem num 100))]))

        ;; handle the last two digits
        (< num 20)                 (numap num)
        (divisible? num 10)        (numap num)
        :else                      (str/join "-" [(numap (* 10 (n-digit num 0)))
                                                  (numap (n-digit num 1))])))))

(defn -main
  "Number letter counts"
  [& args]
  (def answer (->> (range 1 1001)
                   (map numberword)
                   (map #(str/replace % #"[^a-zA-Z]*" ""))
                   (apply str)
                   (count)))
  (println answer)
  answer)
