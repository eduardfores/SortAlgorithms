from readFile import readFile
from writeFile import writeFile
import time

class RadixSort:

    def countingSort(self, arr, exp1):

        n = len(arr)
        output = [0] * (n)

        count = [0] * (10)

        for i in range(0, n):
            index = (arr[i] / exp1)
            count[int(index % 10)] += 1

        for i in range(1, 10):
            count[i] += count[i - 1]

        i = n - 1
        while i >= 0:
            index = (arr[i] / exp1)
            output[count[int(index % 10)] - 1] = arr[i]
            count[int(index % 10)] -= 1
            i -= 1

        i = 0
        for i in range(0, len(arr)):
            arr[i] = output[i]

    def radixSort(self, arr):

        max1 = max(arr)

        exp = 1
        while max1 / exp > 0:
            self.countingSort(arr, exp)
            exp *= 10

    def execution(self):
        fileLength=10
        l = list()

        for i in range(0, 3):
            for j in range(0, 5):
                arr = readFile(fileLength)
                print(fileLength)

                start = time.time()
            
                self.radixSort(arr)

                stop = time.time()
                
                l.append(stop - start)
                
                fileLength *= 10

            writeFile(l, 'RadixSort', 'Run'+str(i+1))
            del l[:]
            fileLength = 10

rs = RadixSort()
rs.execution()