(ns q-028.core-test
  (:require [clojure.test :refer :all]
            [q-028.core :refer :all]))

(deftest q-028-test
  (is (= (-main) 669171001)))
