import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ng-streaming';
  data = 'Test Data';

  constructor() {
    this.getEvent('sse/w');
  }

  ngOnInit(): void {
    console.log(this.data);
  }

  public getEvent<T>(endpoint: string) {
    const source = new EventSource('http://localhost:3000'.concat(`/${endpoint}`));
    source.onmessage = ev => {
      this.data = ev.data;
    };
  }

}
