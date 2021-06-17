from readFile import readFile
from writeFile import writeFile
import time

class MergeSort:

    def mergeSort(self, arr):
        if len(arr) > 1:

            # Finding the mid of the array
            mid = len(arr)//2

            # Dividing the array elements
            L = arr[:mid]

            # into 2 halves
            R = arr[mid:]

            self.mergeSort(L)

            self.mergeSort(R)

            i = j = k = 0

            while i < len(L) and j < len(R):
                if L[i] < R[j]:
                    arr[k] = L[i]
                    i += 1
                else:
                    arr[k] = R[j]
                    j += 1
                k += 1

            while i < len(L):
                arr[k] = L[i]
                i += 1
                k += 1

            while j < len(R):
                arr[k] = R[j]
                j += 1
                k += 1
    
    def execution(self):
        fileLength=10
        l = list()
        
        for i in range(0, 3):
            for j in range(0, 5):
                arr = readFile(fileLength)
                print(fileLength)

                start = time.time()
            
                self.mergeSort(arr)

                stop = time.time()
                
                l.append(stop - start)
                
                fileLength *= 10

            writeFile(l, 'MergeSort', 'Run'+str(i+1))
            del l[:]
            fileLength = 10

ms = MergeSort()

ms.execution()