import { Component, OnInit } from '@angular/core';
import {MenuItem} from 'primeng';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor() { }

  items: MenuItem[];

  ngOnInit() {
    this.items = [
      {label: 'Angular.io', icon: 'pi pi-external-link', url: 'http://angular.io'},
      {label: 'Theming', icon: 'pi pi-palette', routerLink: ['/theming']}
    ];
  }

}
