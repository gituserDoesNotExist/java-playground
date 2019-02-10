function Arbeitnehmer(name,abteilung) {
  this.name = name;
  this.abteilung = abteilung; 
}

function Arbeiter(name,abteilung,projekte) {
  Arbeitnehmer.call(this,name,abteilung);
  this.projekte = projekte;
}
Arbeiter.prototype = new Arbeitnehmer;
Arbeiter.prototype.construcor = Arbeiter; 
delete Arbeiter.prototype.name;
delete Arbeiter.prototype.abteilung; 

function Mechaniker(name,abteilung,projekte,maschine) {
  Arbeiter.call(this,name,abteilung,projekte);
  this.maschine = maschine; 
}
Mechaniker.prototype = new Arbeiter; 
Mechaniker.prototype.construcor = Mechaniker; 
delete Mechaniker.prototype.projekte; 

//Jim erstellen 
jim = new Mechaniker("Jim","Technik","Schweissen","Schweissgeraet");

//Eigenschaften anzeigen
console.log("Jim's Name: " + jim.name);
console.log("Seine Abteilung: " + jim.abteilung);
console.log("Sein Projekt: " + jim.projekte);
console.log("Seine Maschine: " + jim.maschine);

Arbeitnehmer.prototype.printName = function () { console.log(this.name); }
Arbeitnehmer.prototype.printAbteilung = function () { console.log(this.abteilung); }
Arbeiter.prototype.printProjekte = function () { console.log(this.projekte); }
Mechaniker.prototype.printMaschine = function () { console.log(this.maschine); }

jim.printName();
jim.printAbteilung();
jim.printProjekte();
jim.printMaschine();