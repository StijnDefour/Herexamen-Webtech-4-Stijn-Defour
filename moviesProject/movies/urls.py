from django.conf.urls import url

from . import views

urlpatterns = [
    url(r'^getall\/*', views.getall, name='getall')
]
