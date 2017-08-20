(ns q-013.core-test
  (:require [clojure.test :refer :all]
            [q-013.core :refer :all]))

(deftest q-013-test
  (is (= (-main) "5537376230")))
