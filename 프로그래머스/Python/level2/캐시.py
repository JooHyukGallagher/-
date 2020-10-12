from collections import deque


def solution(cacheSize, cities):
    answer = 0

    if cacheSize == 0:
        return len(cities) * 5

    cache = set()
    city_queue = deque()
    for city in cities:
        city = city.lower()
        if city in cache:
            answer += 1
            if city in city_queue:
                city_queue.remove(city)
            city_queue.append(city)
        else:
            answer += 5
            if len(cache) < cacheSize:
                cache.add(city)
                city_queue.append(city)
            else:
                if len(city_queue) != 0:
                    cache.remove(city_queue.popleft())
                cache.add(city)
                if city in city_queue:
                    city_queue.remove(city)
                city_queue.append(city)
    return answer


cacheSize = 3
cities = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA",
          "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]
print(solution(cacheSize, cities))
