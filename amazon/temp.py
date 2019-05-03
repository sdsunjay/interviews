    # WRITE YOUR CODE HERE
    time = 0
    i = 0
    parts.sort()
    temp = parts[0]
    while(i < numOfParts-1):
        sum = temp + parts[i+1]
        temp = sum
        # print("temp: " + str(temp))
        time += sum
        i+=1
        # print("time: " + str(time))
    return time
# time is sum of size of parts
# size of new part = sum of two parts

# find min possible time
