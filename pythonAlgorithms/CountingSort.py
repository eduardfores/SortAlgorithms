from readFile import readFile
from writeFile import writeFile
import time

class CountingSort:

    def countingSort(self, array):
        
        size = len(array)
        _max = max(array)
        _min = min(array)

        count = [0] * ((_max - _min)+1)
        output = [0] * size

        for i in range(0, size):
            count[array[i]-_min] += 1

        for i in range(1, size):
            count[i] += count[i - 1]

        i = size - 1
        while i >= 0:
            output[count[array[i] - _min] - 1] = array[i]
            count[array[i] - _min] -= 1
            i -= 1

        for i in range(0, size):
            array[i] = output[i]

    def execution(self):
      fileLength=10
      l = list()

      for i in range(0, 3):
         for j in range(0, 5):
            arr = readFile(fileLength)
            print(fileLength)

            start = time.time()
		
            self.countingSort(arr)

            stop = time.time()
            
            l.append(stop - start)
            
            fileLength *= 10

         writeFile(l, 'CountingSort', 'Run'+str(i+1))
         del l[:]
         fileLength = 10

cs = CountingSort()

cs.execution()