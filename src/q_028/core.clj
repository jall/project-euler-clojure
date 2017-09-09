(ns q-028.core
  (:gen-class))

; For an n by n grid, with n odd, the corners values are:
; Top right: n^2
; Top left: n^2-n+1
; Bottom left: n^2-2n+2
; Bottom right: n^2-3n+3
; Total: 4n^2-6n+6

(defn corner-sum [n]
  (+ (* 4 n n) (* -6 n) 6))

(defn -main
  "Number spiral diagonals"
  [& args]
  ; Add 1 to final result for center value, start n from 3 to skip center.
  (let [answer (inc (->> (take-while #(>= 1001 %) (iterate #(+ 2 %) 3))
                         (map corner-sum)
                         (apply +)
                         ))]
    (println answer)
    answer))
