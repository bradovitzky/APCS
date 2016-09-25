import pickle, urllib.request
with urllib.request.urlopen('http://www.pythonchallenge.com/pc/def/banner.p') as source:
		data = pickle.load(source)
for el in data:
	print("".join([e[1] * e[0] for e in]))
