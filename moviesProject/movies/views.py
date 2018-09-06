# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render

import redis

r = redis.StrictRedis(host='localhost', port=6379, db=1)

def getall(request):
    movies = r.keys("movie:*")
    new_dict = {}
    for item in movies:
       name = item.pop('name')
       new_dict[name] = item

    print(movies)
    return render(request, 'movies/index.html', new_dict)

# Create your views here.
