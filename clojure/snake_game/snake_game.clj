(ns reader.sname
  (:import (java.awt Color Dimension)
           (javax.swing JPanel JFrame Timer JOptionPane)
           (java.awt.event ActionListener KeyListener))
  (:use clojure.contrib.import-static
        [clojure.contrib.seq-util :only (includes?)]))
(import-static java.awt.event.KeyEvent VK_LEFT VK_RIGHT VK_UP VK_DOWN)

(def width 75)
(def height 50)
(def point-size 10)
(def turn-millis 75)
(def win-length 5)
(def dir {VK_LEFT   [-1 0]
          VK_RIGHT  [1 0]
          VK_UP     [0 -1]
          VK_DOWN   [0 1]})

; [x y] [x y] ... -> [added-x added-y]
(defn add-points[& pts]
  (vec (apply map + pts)))

; [x y] -> [screen-x screen-y widht height]
(defn point-to-screen-rect [pt]
  (map #(* point-size %) [(pt 0) (pt 1) 1 1])) ; (pt 0) vectorの添字演算

