(defn hello-world []
	(println "hello world"))

(deftest test-hello-world
  (is (nil? (hello-world))))

