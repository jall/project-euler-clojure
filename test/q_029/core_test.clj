(ns q-029.core-test
  (:require [clojure.test :refer :all]
            [q-029.core :refer :all]))

(deftest q-029-test
  (is (= (-main) 9183)))
