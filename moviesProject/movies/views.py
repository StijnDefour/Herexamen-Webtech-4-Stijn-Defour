# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render

import redis

def getall(request):
    return render(request, 'movies/index.html', {'movies': movies})

# Create your views here.
