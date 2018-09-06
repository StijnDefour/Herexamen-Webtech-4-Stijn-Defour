# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

class Actor(models.Model):
    name = models.CharField(max_length=60)
    def __str__(self):
        return self.name

class Movie(models.Model):
    name = models.CharField(max_length=30)
    actors = models.ManyToManyField(Actor)

# actor = Actor.objects.create(name='Al Pacino')
# actor.save()
# actor = Actor.objects.create(name='Marlon Brando')
# actor.save()
# actor = Actor.objects.create(name='Robert Duvall')
# actor.save()
# actor = Actor.objects.create(name='Liam Neeson')
# actor.save()
# actor = Actor.objects.create(name='Ralph Fiennes')
# actor.save()
# actor = Actor.objects.create(name='Ben Kingsley')
# actor.save()
# actor = Actor.objects.create(name='Ryan Tom Hanks')
# actor.save()
# actor = Actor.objects.create(name='Matt Damon')
# actor.save()
# actor = Actor.objects.create(name='Vin Diesel')
# actor.save()
# actor = Actor.objects.create(name='Michael J. Fox')
# actor.save()
# actor = Actor.objects.create(name='Christopher Lloyd')
# actor.save()
# actor = Actor.objects.create(name='Lea Thompson')
# actor.save()
# actor = Actor.objects.create(name='Ingrid Bergman')
# actor.save()
# actor = Actor.objects.create(name='Humphrey Bogart')
# actor.save()
# actor = Actor.objects.create(name='Peter Lorre')
# actor.save()
# actor = Actor.objects.create(name='Julianne Moore')
# actor.save()
# actor = Actor.objects.create(name='Jeff Bridges')
# actor.save()
# actor = Actor.objects.create(name='Tara Reid')
# actor.save()
