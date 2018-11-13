(ns q-024.core
  (:gen-class)
  (:require [numbers.factorial :refer [factorial]]))

(defn lehmer-code
  "The Lehmer code is a way to encode permutations of a sequence of numbers.
  https://en.wikipedia.org/wiki/Lehmer_code"
  [position length]
  (if (>= 1 length)
    [0]
    (let [multiplier (factorial (dec length))
          digit (quot position multiplier)]
      (into [] (cons digit (lehmer-code (mod position multiplier) (dec length)))))))

(defn lehmer-code-to-permutation
  "Takes a sequence of items and permutes them according to the Lehmer code specified"
  ([original code]
   (lehmer-code-to-permutation original code []))
  ([original code permutation]
   (if (zero? (count code))
     permutation
     (let [position (first code)]
       (recur
        (vec (concat (subvec original 0 position) (subvec original (inc position))))
        (vec (rest code))
        (conj permutation (nth original position)))))))

(defn numbers-to-string [numbers]
  (apply str numbers))

(defn -main
  "Lexicographic permutations"
  [& args]
  (let [inputs [0 1 2 3 4 5 6 7 8 9]
        lehmer-code (lehmer-code 1e6 (count inputs))
        answer (numbers-to-string (lehmer-code-to-permutation inputs lehmer-code))]
    (println answer)
    answer))
