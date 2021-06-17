from readFile import readFile
from writeFile import writeFile
import time

class InsertationSort:

    def insertionSort(self, arr):

        for i in range(1, len(arr)):

            key = arr[i]

            j = i-1
            while j >= 0 and key < arr[j] :
                    arr[j + 1] = arr[j]
                    j -= 1
            arr[j + 1] = key

    def execution(self):
      fileLength=10
      l = list()

      for i in range(0, 3):
         for j in range(0, 5):
            arr = readFile(fileLength)
            print(fileLength)

            start = time.time()
		
            self.insertionSort(arr)

            stop = time.time()
            
            l.append(stop - start)
            
            fileLength *= 10

         writeFile(l, 'InserationSort', 'Run'+str(i+1))
         del l[:]
         fileLength = 10


insertationSort = InsertationSort()
insertationSort.execution()
