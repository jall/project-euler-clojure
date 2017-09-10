(ns q-030.core-test
  (:require [clojure.test :refer :all]
            [q-030.core :refer :all]))

(deftest q-030-test
  (is (= (-main) 443839)))
