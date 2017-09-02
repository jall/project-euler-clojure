(ns q-023.core-test
  (:require [clojure.test :refer :all]
            [q-023.core :refer :all]))

(deftest q-023-test
  (is (= (-main) 4179871)))
