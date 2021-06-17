from readFile import readFile
from writeFile import writeFile
import time

class BucketSort:

    def insertionSort(self, bucket):
        for i in range (1, len (bucket)):
            var = bucket[i]
            j = i - 1
            while (j >= 0 and var < bucket[j]):
                bucket[j + 1] = bucket[j]
                j = j - 1
            bucket[j + 1] = var	
                
    def bucketSort(self, input_list):
        
        max_value = max(input_list)
        size = max_value/len(input_list)

        buckets_list= []
        for x in range(len(input_list)):
            buckets_list.append([]) 

        for i in range(len(input_list)):
            j = int (input_list[i] / size)
            if j != len (input_list):
                buckets_list[j].append(input_list[i])
            else:
                buckets_list[len(input_list) - 1].append(input_list[i])

        for z in range(len(input_list)):
            self.insertionSort(buckets_list[z])
                
        final_output = []
        for x in range(len (input_list)):
            final_output = final_output + buckets_list[x]
        return final_output

    def execution(self):
      fileLength=10
      l = list()

      for i in range(0, 3):
         for j in range(0, 5):
            arr = readFile(fileLength)
            print(fileLength)
            start = time.time()
		
            self.bucketSort(arr)

            stop = time.time()
            
            l.append(stop - start)
            
            fileLength *= 10

         writeFile(l, 'BucketSort', 'Run'+str(i+1))
         del l[:]
         fileLength = 10

bs = BucketSort()

bs.execution()
