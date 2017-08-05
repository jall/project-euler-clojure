(ns q-004.core
  (:gen-class))

(defn is-palindrome? [input]
  (let [string (str input)]
    (= string (clojure.string/reverse string))))

(defn target-numbers []
  (for [x (range 999 99 -1)
        y (range 999 99 -1)]
    (* x y)))

(defn palindromes []
  (filter is-palindrome? (target-numbers)))

(defn -main
  "Largest palindrome product"
  [& args]
  (def answer (apply max (palindromes)))
  (println answer)
  answer)
