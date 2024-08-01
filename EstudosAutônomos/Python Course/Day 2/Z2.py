print("Tip calculator")

total_bill = float(input("What was the total bill? "))

tip = float(input("How much tip would you like to give? "))

n_people = int(input("How many people to split the bill?" ))

result = (total_bill + tip) / n_people

result = str(result)

print("Each person should pay: $" + result)