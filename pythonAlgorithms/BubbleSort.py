from readFile import readFile
from writeFile import writeFile
import time

class BubbleSort:

   def bubbleSort(self, arr):
      n = len(arr)
      for i in range(n):
         for j in range(0, n-i-1):
            if arr[j] > arr[j+1] :
               arr[j], arr[j+1] = arr[j+1], arr[j]

   def execution(self):
      fileLength=10
      l = list()

      for i in range(0, 3):
         for j in range(0, 5):
            arr = readFile(fileLength)
            print(fileLength)

            start = time.time()
		
            self.bubbleSort(arr)

            stop = time.time()
            
            l.append(stop - start)
            
            fileLength *= 10

         writeFile(l, 'bubbleSort', 'Run'+str(i+1))
         del l[:]
         fileLength = 10
      

bs = BubbleSort()

bs.execution()
