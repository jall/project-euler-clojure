(ns q-017.core-test
  (:require [clojure.test :refer :all]
            [q-017.core :refer :all]))

(deftest q-017-test
  (is (= (-main) 21124)))
