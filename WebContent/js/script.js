
(function(e,g,b,i,c,j,k){new(function(){});
var d={Lc:function(a){return-b.cos(a*b.PI)/2+.5},Mc:function(a){return a},df:function(a){return a*a},Bc:function(a){return-a*(a-2)},ef:function(a){return(a*=2)<1?1/2*a*a:-1/2*(--a*(a-2)-1)},ff:function(a){return a*a*a},gf:function(a){return(a-=1)*a*a+1},hf:function(a){return(a*=2)<1?1/2*a*a*a:1/2*((a-=2)*a*a+2)},jf:function(a){return a*a*a*a},kf:function(a){return-((a-=1)*a*a*a-1)},lf:function(a){return(a*=2)<1?1/2*a*a*a*a:-1/2*((a-=2)*a*a*a-2)},mf:function(a){return a*a*a*a*a},nf:function(a){return(a-=1)*a*a*a*a+1},of:function(a){return(a*=2)<1?1/2*a*a*a*a*a:1/2*((a-=2)*a*a*a*a+2)},pf:function(a){return 1-b.cos(a*b.PI/2)},qf:function(a){return b.sin(a*b.PI/2)},rf:function(a){return-1/2*(b.cos(b.PI*a)-1)},sf:function(a){return a==0?0:b.pow(2,10*(a-1))},Gf:function(a){return a==1?1:-b.pow(2,-10*a)+1},Ff:function(a){return a==0||a==1?a:(a*=2)<1?1/2*b.pow(2,10*(a-1)):1/2*(-b.pow(2,-10*--a)+2)},Ef:function(a){return-(b.sqrt(1-a*a)-1)},Df:function(a){return b.sqrt(1-(a-=1)*a)},Cf:function(a){return(a*=2)<1?-1/2*(b.sqrt(1-a*a)-1):1/2*(b.sqrt(1-(a-=2)*a)+1)},Bf:function(a){if(!a||a==1)return a;var c=.3,d=.075;return-(b.pow(2,10*(a-=1))*b.sin((a-d)*2*b.PI/c))},Hf:function(a){if(!a||a==1)return a;var c=.3,d=.075;return b.pow(2,-10*a)*b.sin((a-d)*2*b.PI/c)+1},Af:function(a){if(!a||a==1)return a;var c=.45,d=.1125;return(a*=2)<1?-.5*b.pow(2,10*(a-=1))*b.sin((a-d)*2*b.PI/c):b.pow(2,-10*(a-=1))*b.sin((a-d)*2*b.PI/c)*.5+1},yf:function(a){var b=1.70158;return a*a*((b+1)*a-b)},xf:function(a){var b=1.70158;return(a-=1)*a*((b+1)*a+b)+1},wf:function(a){var b=1.70158;return(a*=2)<1?1/2*a*a*(((b*=1.525)+1)*a-b):1/2*((a-=2)*a*(((b*=1.525)+1)*a+b)+2)},td:function(a){return 1-d.jc(1-a)},jc:function(a){return a<1/2.75?7.5625*a*a:a<2/2.75?7.5625*(a-=1.5/2.75)*a+.75:a<2.5/2.75?7.5625*(a-=2.25/2.75)*a+.9375:7.5625*(a-=2.625/2.75)*a+.984375},vf:function(a){return a<1/2?d.td(a*2)*.5:d.jc(a*2-1)*.5+.5},uf:function(){return 1-b.abs(1)},tf:function(a){return 1-b.cos(a*b.PI*2)},af:function(a){return b.sin(a*b.PI*2)},zf:function(a){return 1-((a*=2)<1?(a=1-a)*a*a:(a-=1)*a*a)},Ze:function(a){return(a*=2)<1?a*a*a:(a=2-a)*a*a}},f={Pe:d.Lc,te:d.Mc,ue:d.df,ve:d.Bc,we:d.ef,xe:d.ff,ye:d.gf,ze:d.hf,Ae:d.jf,Be:d.kf,Ce:d.lf,De:d.mf,Tc:d.nf,Ee:d.of,Fe:d.pf,Ge:d.qf,He:d.rf,Ie:d.sf,Je:d.Gf,We:d.Ff,Ve:d.Ef,Ue:d.Df,Te:d.Cf,Se:d.Bf,Re:d.Hf,Xe:d.Af,Qe:d.yf,Oe:d.xf,Ne:d.wf,Me:d.td,Jf:d.jc,Le:d.vf,Ke:d.uf,Ye:d.tf,If:d.af,Uf:d.zf,Kf:d.Ze};var a=new function(){var f=this,Eb=/\S+/g,J=1,zb=2,eb=3,db=4,ib=5,C,q=0,h=0,r=0,L=0,y=0,D=navigator,nb=D.appName,n=D.userAgent,o=parseFloat;function Bb(){if(!C){C={hg:"ontouchstart"in e||"createTouch"in g};var a;if(D.pointerEnabled||(a=D.msPointerEnabled))C.qd=a?"msTouchAction":"touchAction"}return C}function t(j){if(!q){q=-1;if(nb=="Microsoft Internet Explorer"&&!!e.attachEvent&&!!e.ActiveXObject){var f=n.indexOf("MSIE");q=J;r=o(n.substring(f+5,n.indexOf(";",f)));/*@cc_on L=@_jscript_version@*/;h=g.documentMode||r}else if(nb=="Netscape"&&!!e.addEventListener){var d=n.indexOf("Firefox"),b=n.indexOf("Safari"),i=n.indexOf("Chrome"),c=n.indexOf("AppleWebKit");if(d>=0){q=zb;h=o(n.substring(d+8))}else if(b>=0){var k=n.substring(0,b).lastIndexOf("/");q=i>=0?db:eb;h=o(n.substring(k+1,b))}else{var a=/Trident\/.*rv:([0-9]{1,}[\.0-9]{0,})/i.exec(n);if(a){q=J;h=r=o(a[1])}}if(c>=0)y=o(n.substring(c+12))}else{var a=/(opera)(?:.*version|)[ \/]([\w.]+)/i.exec(n);if(a){q=ib;h=o(a[2])}}}return j==q}function p(){return t(J)}function P(){return p()&&(h<6||g.compatMode=="BackCompat")}function cb(){return t(eb)}function hb(){return t(ib)}function vb(){return cb()&&y>534&&y<535}function Q(){t();return y>37||h>40||q==J&&h>=11}function N(){return p()&&h<9}function wb(a){var b,d;return function(f){if(!b){b=c;var e=a.substr(0,1).toUpperCase()+a.substr(1);m([a].concat(["WebKit","ms","Moz","O","webkit"]),function(g,c){var b=a;if(c)b=g+e;if(f.style[b]!=k)return d=b})}return d}}function tb(b){var a;return function(c){a=a||wb(b)(c)||b;return a}}var sb=tb("transform");
function mb(a){return{}.toString.call(a)}var I;
function Kb(){if(!I){I={};
m(["Boolean","Number","String","Function","Array","Date","RegExp","Object"],function(a){I["[object "+a+"]"]=a.toLowerCase()})}return I}function m(b,d){var a,c;if(mb(b)=="[object Array]"){for(a=0;a<b.length;a++)if(c=d(b[a],a,b))return c}else for(a in b)if(c=d(b[a],a,b))return c}function A(a){return a==i?String(a):Kb()[mb(a)]||"object"}function kb(a){for(var b in a)return c}function z(a){try{return A(a)=="object"&&!a.nodeType&&a!=a.window&&(!a.constructor||{}.hasOwnProperty.call(a.constructor.prototype,"isPrototypeOf"))}catch(b){}}function x(a,b){return{x:a,y:b}}function qb(b,a){setTimeout(b,a||0)}function G(b,d,c){var a=!b||b=="inherit"?"":b;m(d,function(c){var b=c.exec(a);if(b){var d=a.substr(0,b.index),e=a.substr(b.lastIndex+1,a.length-(b.lastIndex+1));a=d+e}});a=c+(a.indexOf(" ")!=0?" ":"")+a;return a}function yb(b,a){if(h<9)b.style.filter=a}function Gb(g,a,i){if(!L||L<9){var d=a.v,e=a.z,j=(a.A||0)%360,h="";if(j||d!=k||e!=k){if(d==k)d=1;if(e==k)e=1;var c=f.dg(j/180*b.PI,d||1,e||1),i=f.cg(c,a.Q,a.R);f.Lf(g,i.y);f.Mf(g,i.x);h="progid:DXImageTransform.Microsoft.Matrix(M11="+c[0][0]+", M12="+c[0][1]+", M21="+c[1][0]+", M22="+c[1][1]+", SizingMethod='auto expand')"}var m=g.style.filter,n=new RegExp(/[\s]*progid:DXImageTransform\.Microsoft\.Matrix\([^\)]*\)/g),l=G(m,[n],h);yb(g,l)}}f.eg=Bb;f.kd=p;f.Pf=cb;f.Sf=Q;f.xc=N;wb("transform");f.Ac=function(){return h};f.sb=qb;function X(a){a.constructor===X.caller&&a.Dc&&a.Dc.apply(a,X.caller.arguments)}f.Dc=X;f.ob=function(a){if(f.Tf(a))a=g.getElementById(a);return a};function s(a){return a||e.event}f.Fc=s;f.Yb=function(b){b=s(b);var a=b.target||b.srcElement||g;if(a.nodeType==3)a=f.Gc(a);return a};f.Oc=function(a){a=s(a);return{x:a.pageX||a.clientX||0,y:a.pageY||a.clientY||0}};function B(c,d,a){if(a!==k)c.style[d]=a==k?"":a;else{var b=c.currentStyle||c.style;a=b[d];if(a==""&&e.getComputedStyle){b=c.ownerDocument.defaultView.getComputedStyle(c,i);b&&(a=b.getPropertyValue(d)||b[d])}return a}}function Z(b,c,a,d){if(a!==k){if(a==i)a="";else d&&(a+="px");B(b,c,a)}else return o(B(b,c))}function l(c,a){var d=a?Z:B,b;if(a&4)b=tb(c);return function(e,f){return d(e,b?b(e):c,f,a&2)}}function Hb(b){if(p()&&r<9){var a=/opacity=([^)]*)/.exec(b.style.filter||"");return a?o(a[1])/100:1}else return o(b.style.opacity||"1")}function Jb(c,a,f){if(p()&&r<9){var h=c.style.filter||"",i=new RegExp(/[\s]*alpha\([^\)]*\)/g),e=b.round(100*a),d="";if(e<100||f)d="alpha(opacity="+e+") ";var g=G(h,[i],d);yb(c,g)}else c.style.opacity=a==1?"":b.round(a*100)/100}var K={A:["rotate"],vb:["rotateX"],tb:["rotateY"],Eb:["skewX"],Fb:["skewY"]};if(!Q())K=w(K,{v:["scaleX",2],z:["scaleY",2],db:["translateZ",1]});function ub(e,b){if(p()&&h&&h<10){delete b.vb;delete b.tb}var d=sb(e);if(d){var c="";if(b){a.j(b,function(d,e){var a=K[e];if(a){var b=a[1]||0;if(d||b)c+=" "+a[0]+"("+d+(["deg","px",""])[b]+")"}});if(Q()){if(b.H||b.P||b.db)c+=" translate3d("+(b.H||0)+"px,"+(b.P||0)+"px,"+(b.db||0)+"px)";if(b.v==k)b.v=1;if(b.z==k)b.z=1;if(b.v!=1||b.z!=1)c+=" scale3d("+b.v+", "+b.z+", 1)"}}e.style[d]=c}}f.Nc=function(b,a){if(vb())qb(f.M(i,ub,b,a));else(N()?Gb:ub)(b,a)};f.yc=l("transformOrigin",4);f.Vf=l("backfaceVisibility",4);f.Wf=l("transformStyle",4);f.Xf=l("perspective",6);f.Yf=l("perspectiveOrigin",4);f.Zf=function(a,c){if(p()&&r<9||r<10&&P())a.style.zoom=c==1?"":c;else{var b=sb(a);if(b){var f="scale("+c+")",e=a.style[b],g=new RegExp(/[\s]*scale\(.*?\)/g),d=G(e,[g],f);a.style[b]=d}}};var gb=0,bb=0;f.ag=function(b,a){return N()?function(){var g=c,d=P()?b.document.body:b.document.documentElement;if(d){var f=d.offsetWidth-gb,e=d.offsetHeight-bb;if(f||e){gb+=f;bb+=e}else g=j}g&&a()}:a};f.nc=function(b,a){return function(c){c=s(c);var e=c.type,d=c.relatedTarget||(e=="mouseout"?c.toElement:c.fromElement);(!d||d!==a&&!f.bg(a,d))&&b(c)}};f.a=function(a,d,b,c){a=f.ob(a);if(a.addEventListener){d=="mousewheel"&&a.addEventListener("DOMMouseScroll",b,c);a.addEventListener(d,b,c)}else if(a.attachEvent){a.attachEvent("on"+d,b);c&&a.setCapture&&a.setCapture()}};f.K=function(a,c,d,b){a=f.ob(a);if(a.removeEventListener){c=="mousewheel"&&a.removeEventListener("DOMMouseScroll",d,b);a.removeEventListener(c,d,b)}else if(a.detachEvent){a.detachEvent("on"+c,d);b&&a.releaseCapture&&a.releaseCapture()}};f.zb=function(a){a=s(a);a.preventDefault&&a.preventDefault();a.cancel=c;a.returnValue=j};f.Nf=function(a){a=s(a);a.stopPropagation&&a.stopPropagation();a.cancelBubble=c};f.M=function(d,c){var a=[].slice.call(arguments,2),b=function(){var b=a.concat([].slice.call(arguments,0));return c.apply(d,b)};return b};f.re=function(a,b){if(b==k)return a.textContent||a.innerText;var c=g.createTextNode(b);f.mc(a);a.appendChild(c)};f.bb=function(d,c){for(var b=[],a=d.firstChild;a;a=a.nextSibling)(c||a.nodeType==1)&&b.push(a);return b};function lb(a,c,e,b){b=b||"u";for(a=a?a.firstChild:i;a;a=a.nextSibling)if(a.nodeType==1){if(U(a,b)==c)return a;if(!e){var d=lb(a,c,e,b);if(d)return d}}}f.E=lb;function S(a,d,f,b){b=b||"u";var c=[];for(a=a?a.firstChild:i;a;a=a.nextSibling)if(a.nodeType==1){U(a,b)==d&&c.push(a);if(!f){var e=S(a,d,f,b);if(e.length)c=c.concat(e)}}return c}function fb(a,c,d){for(a=a?a.firstChild:i;a;a=a.nextSibling)if(a.nodeType==1){if(a.tagName==c)return a;if(!d){var b=fb(a,c,d);if(b)return b}}}f.Rf=fb;f.Of=function(b,a){return b.getElementsByTagName(a)};function w(){var e=arguments,d,c,b,a,g=1&e[0],f=1+g;d=e[f-1]||{};for(;f<e.length;f++)if(c=e[f])for(b in c){a=c[b];if(a!==k){a=c[b];var h=d[b];d[b]=g&&(z(h)||z(a))?w(g,{},h,a):a}}return d}f.L=w;function Y(f,g){var d={},c,a,b;for(c in f){a=f[c];b=g[c];if(a!==b){var e;if(z(a)&&z(b)){a=Y(a,b);e=!kb(a)}!e&&(d[c]=a)}}return d}f.gd=function(a){return A(a)=="function"};f.Tf=function(a){return A(a)=="string"};f.Tb=function(a){return!isNaN(o(a))&&isFinite(a)};f.j=m;f.fg=z;function R(a){return g.createElement(a)}f.Cb=function(){return R("DIV")};f.ng=function(){return R("SPAN")};f.Ic=function(){};function V(b,c,a){if(a==k)return b.getAttribute(c);b.setAttribute(c,a)}function U(a,b){return V(a,b)||V(a,"data-"+b)}f.D=V;f.k=U;function u(b,a){if(a==k)return b.className;b.className=a}f.Hc=u;function pb(b){var a={};m(b,function(b){a[b]=b});return a}function rb(b,a){return b.match(a||Eb)}function O(b,a){return pb(rb(b||"",a))}f.se=rb;function ab(b,c){var a="";m(c,function(c){a&&(a+=b);a+=c});return a}function F(a,c,b){u(a,ab(" ",w(Y(O(u(a)),O(c)),O(b))))}f.Gc=function(a){return a.parentNode};f.V=function(a){f.Z(a,"none")};f.U=function(a,b){f.Z(a,b?"none":"")};f.wd=function(b,a){b.removeAttribute(a)};f.yd=function(){return p()&&h<10};f.Ad=function(d,c){if(c)d.style.clip="rect("+b.round(c.g)+"px "+b.round(c.q)+"px "+b.round(c.p)+"px "+b.round(c.i)+"px)";else{var g=d.style.cssText,f=[new RegExp(/[\s]*clip: rect\(.*?\)[;]?/i),new RegExp(/[\s]*cliptop: .*?[;]?/i),new RegExp(/[\s]*clipright: .*?[;]?/i),new RegExp(/[\s]*clipbottom: .*?[;]?/i),new RegExp(/[\s]*clipleft: .*?[;]?/i)],e=G(g,f,"");a.Db(d,e)}};f.T=function(){return+new Date};f.X=function(b,a){b.appendChild(a)};f.yb=function(b,a,c){(c||a.parentNode).insertBefore(b,a)};f.Jb=function(b,a){a=a||b.parentNode;a&&a.removeChild(b)};f.Cd=function(a,b){m(a,function(a){f.Jb(a,b)})};f.mc=function(a){f.Cd(f.bb(a,c),a)};f.Xd=function(a,b){var c=f.Gc(a);b&1&&f.O(a,(f.m(c)-f.m(a))/2);b&2&&f.N(a,(f.n(c)-f.n(a))/2)};f.Xb=function(b,a){return parseInt(b,a||10)};f.Yd=o;f.bg=function(b,a){var c=g.body;while(a&&b!==a&&c!==a)try{a=a.parentNode}catch(d){return j}return b===a};function W(d,c,b){var a=d.cloneNode(!c);!b&&f.wd(a,"id");return a}f.rb=W;f.ub=function(e,g){var a=new Image;function b(e,c){f.K(a,"load",b);f.K(a,"abort",d);f.K(a,"error",d);g&&g(a,c)}function d(a){b(a,c)}if(hb()&&h<11.6||!e)b(!e);else{f.a(a,"load",b);f.a(a,"abort",d);f.a(a,"error",d);a.src=e}};f.Zd=function(d,a,e){var c=d.length+1;function b(b){c--;if(a&&b&&b.src==a.src)a=b;!c&&e&&e(a)}m(d,function(a){f.ub(a.src,b)});b()};f.ae=function(b,g,i,h){if(h)b=W(b);var c=S(b,g);if(!c.length)c=a.Of(b,g);for(var f=c.length-1;f>-1;f--){var d=c[f],e=W(i);u(e,u(d));a.Db(e,d.style.cssText);a.yb(e,d);a.Jb(d)}return b};function Lb(b){var l=this,p="",r=["av","pv","ds","dn"],e=[],q,j=0,h=0,d=0;function i(){F(b,q,e[d||j||h&2||h]);a.Y(b,"pointer-events",d?"none":"")}function c(){j=0;i();f.K(g,"mouseup",c);f.K(g,"touchend",c);f.K(g,"touchcancel",c)}function o(a){if(d)f.zb(a);else{j=4;i();f.a(g,"mouseup",c);f.a(g,"touchend",c);f.a(g,"touchcancel",c)}}l.be=function(a){if(a===k)return h;h=a&2||a&1;i()};l.Pc=function(a){if(a===k)return!d;d=a?0:3;i()};l.I=b=f.ob(b);var n=a.se(u(b));
if(n)p=n.shift();
m(r,function(a){e.push(p+a)});
q=ab(" ",e);e.unshift("");
f.a(b,"mousedown",o);
f.a(b,"touchstart",o)}f.kc=function(a){return new Lb(a)};
f.Y=B;f.Bb=l("overflow");f.N=l("top",2);f.O=l("left",2);
f.m=l("width",2);f.n=l("height",2);
f.Mf=l("marginLeft",2);f.Lf=l("marginTop",2);
f.F=l("position");f.Z=l("display");
f.C=l("zIndex",1);f.gc=function(b,a,c){if(a!=k)Jb(b,a,c);else return Hb(b)};f.Db=function(a,b){if(b!=k)a.style.cssText=b;else return a.style.cssText};var T={J:f.gc,g:f.N,i:f.O,qb:f.m,pb:f.n,nb:f.F,zg:f.Z,wb:f.C},M;function H(){if(!M)M=w({f:f.Ad,u:f.Nc},T);return M}function jb(){var a={};a.u=a.u;a.u=a.A;a.u=a.vb;a.u=a.tb;a.u=a.Eb;a.u=a.Fb;a.u=a.H;a.u=a.P;a.u=a.db;return H()}f.ee=H;f.ge=jb;f.jb=function(c,b){var a=H();m(b,function(d,b){a[b]&&a[b](c,d)})};var E=new function(){var a=this;function b(d,g){for(var j=d[0].length,i=d.length,h=g[0].length,f=[],c=0;c<i;c++)for(var k=f[c]=[],b=0;b<h;b++){for(var e=0,a=0;a<j;a++)e+=d[c][a]*g[a][b];k[b]=e}return f}a.v=function(b,c){return a.Uc(b,c,0)};a.z=function(b,c){return a.Uc(b,0,c)};a.Uc=function(a,c,d){return b(a,[[c,0],[0,d]])};a.Ab=function(d,c){var a=b(d,[[c.x],[c.y]]);return x(a[0][0],a[1][0])}};f.dg=function(d,a,c){var e=b.cos(d),f=b.sin(d);return[[e*a,-f*c],[f*a,e*c]]};f.cg=function(d,c,a){var e=E.Ab(d,x(-c/2,-a/2)),f=E.Ab(d,x(c/2,-a/2)),g=E.Ab(d,x(c/2,a/2)),h=E.Ab(d,x(-c/2,a/2));return x(b.min(e.x,f.x,g.x,h.x)+c/2,b.min(e.y,f.y,g.y,h.y)+a/2)};var Db={s:1,v:1,z:1,A:0,vb:0,tb:0,H:0,P:0,db:0,Eb:0,Fb:0};f.Xc=function(b){var c=b||{};if(b)if(a.gd(b))c={Hb:c};else if(a.gd(b.f))c.f={Hb:b.f};return c};function ob(c,a){var b={};m(c,function(c,d){var e=c;if(a[d]!=k)if(f.Tb(c))e=c+a[d];else e=ob(c,a[d]);b[d]=e});return b}f.he=ob;f.ie=function(l,m,w,n,y,z,o){var c=m;if(l){c={};for(var g in m){var A=z[g]||1,v=y[g]||[0,1],e=(w-v[0])/v[1];e=b.min(b.max(e,0),1);e=e*A;var u=b.floor(e);if(e!=u)e-=u;var h=n.Hb||d.Lc,j,B=l[g],q=m[g];if(a.Tb(q)){h=n[g]||h;var x=h(e);j=B+q*x}else{j=a.L({ib:{}},l[g]);a.j(q.ib||q,function(d,a){if(n.f)h=n.f[a]||n.f.Hb||h;var c=h(e),b=d*c;j.ib[a]=b;j[a]+=b})}c[g]=j}var r,f={Q:o.Q,R:o.R};a.j(Db,function(d,a){r=r||m[a];var b=c[a];if(b!=k){if(b!=d)f[a]=b;delete c[a]}else if(l[a]!=k)f[a]=l[a]});if(r){if(f.s)f.v=f.z=f.s;c.u=f}}if(m.f&&o.Ib){var p=c.f.ib,t=(p.g||0)+(p.p||0),s=(p.i||0)+(p.q||0);c.i=(c.i||0)+s;c.g=(c.g||0)+t;c.f.i-=s;c.f.q-=s;c.f.g-=t;c.f.p-=t}if(c.f&&a.yd()&&!c.f.g&&!c.f.i&&c.f.q==o.Q&&c.f.p==o.R)c.f=i;return c}};function m(){var b=this,d=[];function i(a,b){d.push({vc:a,rc:b})}function h(b,c){a.j(d,function(a,e){a.vc==b&&a.rc===c&&d.splice(e,1)})}b.kb=b.addEventListener=i;b.removeEventListener=h;b.l=function(b){var c=[].slice.call(arguments,1);a.j(d,function(a){a.vc==b&&a.rc.apply(e,c)})}}var l=function(y,C,k,O,L,K){y=y||0;var d=this,q,n,o,u,z=0,G,H,F,B,x=0,h=0,m=0,D,l,g,f,p,w=[],A;function N(a){g+=a;f+=a;l+=a;h+=a;m+=a;x+=a}function t(n){var e=n;if(p&&(e>=f||e<=g))e=((e-g)%p+p)%p+g;if(!D||u||h!=e){var i=b.min(e,f);i=b.max(i,g);if(!D||u||i!=m){if(K){var j=(i-l)/(C||1);if(k.ed)j=1-j;var o=a.ie(L,K,j,G,F,H,k);a.j(o,function(b,a){A[a]&&A[a](O,b)})}d.oc(m-l,i-l);m=i;a.j(w,function(b,c){var a=n<h?w[w.length-c-1]:b;a.B(m-x)});var r=h,q=m;h=e;D=c;d.Rb(r,q)}}}function E(a,c,d){c&&a.Sb(f);if(!d){g=b.min(g,a.qc()+x);f=b.max(f,a.Mb()+x)}w.push(a)}var r=e.requestAnimationFrame||e.webkitRequestAnimationFrame||e.mozRequestAnimationFrame||e.msRequestAnimationFrame;if(a.Pf()&&a.Ac()<7)r=i;r=r||function(b){a.sb(b,k.ad)};function I(){if(q){var d=a.T(),e=b.min(d-z,k.Zc),c=h+e*o;z=d;if(c*o>=n*o)c=n;t(c);if(!u&&c*o>=n*o)J(B);else r(I)}}function s(e,i,j){if(!q){q=c;u=j;B=i;e=b.max(e,g);e=b.min(e,f);n=e;o=n<h?-1:1;d.Yc();z=a.T();r(I)}}function J(a){if(q){u=q=B=j;d.Wc();a&&a()}}d.Vc=function(a,b,c){s(a?h+a:f,b,c)};d.Sc=s;d.fb=J;d.oe=function(a){s(a)};d.S=function(){return h};d.Rc=function(){return n};d.hb=function(){return m};d.B=t;d.Ib=function(a){t(h+a)};d.nd=function(){return q};d.Td=function(a){p=a};d.Sb=N;d.mb=function(a,b){E(a,0,b)};d.ec=function(a){E(a,1)};d.Dd=function(a){f+=a};d.qc=function(){return g};d.Mb=function(){return f};d.Rb=d.Yc=d.Wc=d.oc=a.Ic;d.hc=a.T();k=a.L({ad:16,Zc:50},k);p=k.vd;A=a.L({},a.ee(),k.bc);g=l=y;f=y+C;H=k.ud||{};F=k.ld||{};G=a.Xc(k.ab)};new(function(){});var h=function(q,dc){var o=this;function Ac(){var a=this;l.call(a,-1e8,2e8);a.Od=function(){var c=a.hb(),d=b.floor(c),f=t(d),e=c-b.floor(c);return{eb:f,Nd:d,nb:e}};a.Rb=function(d,a){var e=b.floor(a);if(e!=a&&a>d)e++;Sb(e,c);o.l(h.Md,t(a),t(d),a,d)}}function zc(){var b=this;l.call(b,0,0,{vd:r});a.j(C,function(a){D&1&&a.Td(r);b.ec(a);a.Sb(ib/Zb)})}function yc(){var a=this,b=Tb.I;l.call(a,-1,2,{ab:d.Mc,bc:{nb:Yb},vd:r},b,{nb:1},{nb:-2});a.Zb=b}function mc(n,m){var a=this,d,e,g,k,b;l.call(a,-1e8,2e8,{Zc:100});a.Yc=function(){M=c;S=i;o.l(h.Ld,t(w.S()),w.S())};a.Wc=function(){M=j;k=j;var a=w.Od();o.l(h.Kd,t(w.S()),w.S());!a.nb&&Cc(a.Nd,s)};a.Rb=function(i,h){var a;if(k)a=b;else{a=e;if(g){var c=h/g;a=f.wc(c)*(e-d)+d}}w.B(a)};a.Nb=function(b,f,c,h){d=b;e=f;g=c;w.B(b);a.B(0);a.Sc(c,h)};a.Jd=function(d){k=c;b=d;a.Vc(d,i,c)};a.Id=function(a){b=a};w=new Ac;w.mb(n);w.mb(m)}function oc(){var c=this,b=Wb();a.C(b,0);a.Y(b,"pointerEvents","none");c.I=b;c.Pb=function(){a.V(b);a.mc(b)}}function wc(n,e){var d=this,q,L,v,k,y=[],x,B,W,G,Q,F,g,w,p;l.call(d,-u,u+1,{});function E(b){q&&q.Lb();T(n,b,0);F=c;q=new I.G(n,I,a.Yd(a.k(n,"idle"))||kc);q.B(0)}function Z(){q.hc<I.hc&&E()}function M(p,r,n){if(!G){G=c;if(k&&n){var g=n.width,b=n.height,m=g,l=b;if(g&&b&&f.xb){if(f.xb&3&&(!(f.xb&4)||g>K||b>J)){var i=j,q=K/J*b/g;if(f.xb&1)i=q>1;else if(f.xb&2)i=q<1;m=i?g*J/b:K;l=i?J:b*K/g}a.m(k,m);a.n(k,l);a.N(k,(J-l)/2);a.O(k,(K-m)/2)}a.F(k,"absolute");o.l(h.Fd,e)}}a.V(r);p&&p(d)}function Y(b,c,f,g){if(g==S&&s==e&&N)if(!Bc){var a=t(b);A.Rd(a,e,c,d,f);c.Ed();U.Sb(a-U.qc()-1);U.B(a);z.Nb(b,b,0)}}function cb(b){if(b==S&&s==e){if(!g){var a=i;if(A)if(A.eb==e)a=A.Pd();else A.Pb();Z();g=new uc(n,e,a,q);g.od(p)}!g.nd()&&g.Vb()}}function R(c,h,l){if(c==e){if(c!=h)C[h]&&C[h].Ud();else!l&&g&&g.Vd();p&&p.Pc();var m=S=a.T();d.ub(a.M(i,cb,m))}else{var k=b.min(e,c),j=b.max(e,c),o=b.min(j-k,k+r-j),n=u+f.Wd-1;(!Q||o<=n)&&d.ub()}}function db(){if(s==e&&g){g.fb();p&&p.ne();p&&p.me();g.sd()}}function eb(){s==e&&g&&g.fb()}function ab(a){!P&&o.l(h.le,e,a)}function O(){p=w.pInstance;g&&g.od(p)}d.ub=function(d,b){b=b||v;if(y.length&&!G){a.U(b);if(!W){W=c;o.l(h.ke,e);a.j(y,function(b){if(!a.D(b,"src")){b.src=a.k(b,"src2");a.Z(b,b["display-origin"])}})}a.Zd(y,k,a.M(i,M,d,b))}else M(d,b)};d.je=function(){var h=e;if(f.dd<0)h-=r;var c=h+f.dd*sc;if(D&2)c=t(c);if(!(D&1))c=b.max(0,b.min(c,r-u));if(c!=e){if(A){var d=A.Sd(r);if(d){var j=S=a.T(),g=C[t(c)];return g.ub(a.M(i,Y,c,g,d,j),v)}}bb(c)}};d.pc=function(){R(e,e,c)};d.Ud=function(){p&&p.ne();p&&p.me();d.cd();g&&g.pe();g=i;E()};d.Ed=function(){a.V(n)};d.cd=function(){a.U(n)};d.Bd=function(){p&&p.Pc()};function T(b,d,e){if(a.D(b,"jssor-slider"))return;if(!F){if(b.tagName=="IMG"){y.push(b);if(!a.D(b,"src")){Q=c;b["display-origin"]=a.Z(b);a.V(b)}}a.xc()&&a.C(b,(a.C(b)||0)+1)}var f=a.bb(b);a.j(f,function(f){var h=f.tagName,i=a.k(f,"u");if(i=="player"&&!w){w=f;if(w.pInstance)O();else a.a(w,"dataavailable",O)}if(i=="caption"){if(d){a.yc(f,a.k(f,"to"));a.Vf(f,a.k(f,"bf"));a.Wf(f,"preserve-3d")}else if(!a.kd()){var g=a.rb(f,j,c);a.yb(g,f,b);a.Jb(f,b);f=g;d=c}}else if(!F&&!e&&!k){if(h=="A"){if(a.k(f,"u")=="image")k=a.Rf(f,"IMG");else k=a.E(f,"image",c);if(k){x=f;a.Z(x,"block");a.jb(x,V);B=a.rb(x,c);a.F(x,"relative");a.gc(B,0);a.Y(B,"backgroundColor","#000")}}else if(h=="IMG"&&a.k(f,"u")=="image")k=f;if(k){k.border=0;a.jb(k,V)}}T(f,d,e+1)})}d.oc=function(c,b){var a=u-b;Yb(L,a)};d.eb=e;m.call(d);a.Xf(n,a.k(n,"p"));a.Yf(n,a.k(n,"po"));var H=a.E(n,"thumb",c);if(H){a.rb(H);a.V(H)}a.U(n);v=a.rb(fb);a.C(v,1e3);a.a(n,"click",ab);E(c);d.Qd=k;d.Qc=B;d.Zb=L=n;a.X(L,v);o.kb(203,R);o.kb(28,eb);o.kb(24,db)}function uc(y,f,p,q){var b=this,m=0,u=0,g,i,e,d,k,t,r,n=C[f];l.call(b,0,0);function v(){a.mc(L);ac&&k&&n.Qc&&a.X(L,n.Qc);a.U(L,!k&&n.Qd)}function w(){b.Vb()}function x(a){r=a;b.fb();b.Vb()}b.Vb=function(){var a=b.hb();if(!B&&!M&&!r&&s==f){if(!a){if(g&&!k){k=c;b.sd(c);o.l(h.ce,f,m,u,g,d)}v()}var j,p=h.zc;if(a!=d)if(a==e)j=d;else if(a==i)j=e;else if(!a)j=i;else j=b.Rc();o.l(p,f,a,m,i,e,d);var l=N&&(!E||F);if(a==d)(e!=d&&!(E&12)||l)&&n.je();else(l||a!=e)&&b.Sc(j,w)}};b.Vd=function(){e==d&&e==b.hb()&&b.B(i)};b.pe=function(){A&&A.eb==f&&A.Pb();var a=b.hb();a<d&&o.l(h.zc,f,-a-1,m,i,e,d)};b.sd=function(b){p&&a.Bb(jb,b&&p.Ob.xg?"":"hidden")};b.oc=function(b,a){if(k&&a>=g){k=j;v();n.cd();A.Pb();o.l(h.fe,f,m,u,g,d)}o.l(h.xd,f,a,m,i,e,d)};b.od=function(a){if(a&&!t){t=a;a.kb($JssorPlayer$.Hd,x)}};p&&b.ec(p);g=b.Mb();b.ec(q);i=g+q.dc;e=g+q.Ub;d=b.Mb()}function Jb(b,c,d){a.O(b,c);a.N(b,d)}function Yb(c,b){var a=x>0?x:eb,d=zb*b*(a&1),e=Ab*b*(a>>1&1);Jb(c,d,e)}function Ob(){pb=M;Ib=z.Rc();G=w.S()}function fc(){Ob();if(B||!F&&E&12){z.fb();o.l(h.zd)}}function cc(e){if(!B&&(F||!(E&12))&&!z.nd()){var c=w.S(),a=b.ceil(G);if(e&&b.abs(H)>=f.Cc){a=b.ceil(c);a+=hb}if(!(D&1))a=b.min(r-u,b.max(a,0));var d=b.abs(a-c);d=1-b.pow(1-d,5);if(!P&&pb)z.oe(Ib);else if(c==a){sb.Bd();sb.pc()}else z.Nb(c,a,d*Ub)}}function Hb(b){!a.k(a.Yb(b),"nodrag")&&a.zb(b)}function qc(a){Xb(a,1)}function Xb(b,d){b=a.Fc(b);var k=a.Yb(b);if(!O&&!a.k(k,"nodrag")&&rc()&&(!d||b.touches.length==1)){B=c;yb=j;S=i;a.a(g,d?"touchmove":"mousemove",Bb);a.T();P=0;fc();if(!pb)x=0;if(d){var f=b.touches[0];ub=f.clientX;vb=f.clientY}else{var e=a.Oc(b);ub=e.x;vb=e.y}H=0;gb=0;hb=0;o.l(h.de,t(G),G,b)}}function Bb(e){if(B){e=a.Fc(e);var f;if(e.type!="mousemove"){var l=e.touches[0];f={x:l.clientX,y:l.clientY}}else f=a.Oc(e);if(f){var j=f.x-ub,k=f.y-vb;if(b.floor(G)!=G)x=x||eb&O;if((j||k)&&!x){if(O==3)if(b.abs(k)>b.abs(j))x=2;else x=1;else x=O;if(mb&&x==1&&b.abs(k)-b.abs(j)>3)yb=c}if(x){var d=k,i=Ab;if(x==1){d=j;i=zb}if(!(D&1)){if(d>0){var g=i*s,h=d-g;if(h>0)d=g+b.sqrt(h)*5}if(d<0){var g=i*(r-u-s),h=-d-g;if(h>0)d=-g-b.sqrt(h)*5}}if(H-gb<-2)hb=0;else if(H-gb>2)hb=-1;gb=H;H=d;rb=G-H/i/(Y||1);if(H&&x&&!yb){a.zb(e);if(!M)z.Jd(rb);else z.Id(rb)}}}}}function ab(){pc();if(B){B=j;a.T();a.K(g,"mousemove",Bb);a.K(g,"touchmove",Bb);P=H;z.fb();var b=w.S();o.l(h.qe,t(b),b,t(G),G);E&12&&Ob();cc(c)}}function hc(c){if(P){a.Nf(c);var b=a.Yb(c);while(b&&v!==b){b.tagName=="A"&&a.zb(c);try{b=b.parentNode}catch(d){break}}}}function jc(a){C[s];s=t(a);sb=C[s];Sb(a);return s}function Cc(a,b){x=0;jc(a);o.l(h.lg,t(a),b)}function Sb(b,c){wb=b;a.j(T,function(a){a.sc(t(b),b,c)})}function rc(){var b=h.Ec||0,a=X;if(mb)a&1&&(a&=1);h.Ec|=a;return O=a&~b}function pc(){if(O){h.Ec&=~X;O=0}}function Wb(){var b=a.Cb();a.jb(b,V);a.F(b,"absolute");return b}function t(a){return(a%r+r)%r}function ic(a,c){if(c)if(!D){a=b.min(b.max(a+wb,0),r-u);c=j}else if(D&2){a=t(a+wb);c=j}bb(a,f.Kb,c)}function xb(){a.j(T,function(a){a.fc(a.Qb.sg<=F)})}function Ec(){if(!F){F=1;xb();if(!B){E&12&&cc();E&3&&C[s].pc()}}}function Dc(){if(F){F=0;xb();B||!(E&12)||fc()}}function gc(){V={qb:K,pb:J,g:0,i:0};a.j(Q,function(b){a.jb(b,V);a.F(b,"absolute");a.Bb(b,"hidden");a.V(b)});a.jb(fb,V)}function ob(b,a){bb(b,a,c)}function bb(g,e,l){if(Qb&&(!B&&(F||!(E&12))||f.pd)){M=c;B=j;z.fb();if(e==k)e=Ub;var d=Cb.hb(),a=g;if(l){a=d+g;if(g>0)a=b.ceil(a);else a=b.floor(a)}if(D&2)a=t(a);if(!(D&1))a=b.max(0,b.min(a,r-u));var i=(a-d)%r;a=d+i;var h=d==a?0:e*b.abs(i);h=b.min(h,e*u*1.5);z.Nb(d,a,h||1)}}o.Vc=function(){if(!N){N=c;C[s]&&C[s].pc()}};function W(){return a.m(y||q)}function lb(){return a.n(y||q)}o.Q=W;o.R=lb;function Eb(c,d){if(c==k)return a.m(q);if(!y){var b=a.Cb(g);a.Hc(b,a.Hc(q));a.Db(b,a.Db(q));a.Z(b,"block");a.F(b,"relative");a.N(b,0);a.O(b,0);a.Bb(b,"visible");y=a.Cb(g);a.F(y,"absolute");a.N(y,0);a.O(y,0);a.m(y,a.m(q));a.n(y,a.n(q));a.yc(y,"0 0");a.X(y,b);var h=a.bb(q);a.X(q,y);a.Y(q,"backgroundImage","");a.j(h,function(c){a.X(a.k(c,"noscale")?q:b,c);a.k(c,"autocenter")&&Kb.push(c)})}Y=c/(d?a.n:a.m)(y);a.Zf(y,Y);var f=d?Y*W():c,e=d?c:Y*lb();a.m(q,f);a.n(q,e);a.j(Kb,function(b){var c=a.Xb(a.k(b,"autocenter"));a.Xd(b,c)})}o.Qf=Eb;m.call(o);o.I=q=a.ob(q);var f=a.L({xb:0,Wd:1,cc:1,ac:0,ic:j,Gb:1,cb:c,pd:c,dd:1,md:3e3,jd:1,Kb:500,wc:d.Bc,Cc:20,id:0,W:1,rd:0,rg:1,Wb:1,fd:1},dc);f.cb=f.cb&&a.Sf();if(f.qg!=k)f.md=f.qg;if(f.pg!=k)f.W=f.pg;if(f.og!=k)f.rd=f.og;var eb=f.Wb&3,sc=(f.Wb&4)/-4||1,kb=f.tg,I=a.L({G:p,cb:f.cb},f.mg);I.lb=I.lb||I.wg;var Fb=f.gg,Z=f.kg,db=f.vg,R=!f.rg,y,v=a.E(q,"slides",R),fb=a.E(q,"loading",R)||a.Cb(g),Mb=a.E(q,"navigator",R),ec=a.E(q,"arrowleft",R),bc=a.E(q,"arrowright",R),Lb=a.E(q,"thumbnavigator",R),nc=a.m(v),lc=a.n(v),V,Q=[],tc=a.bb(v);a.j(tc,function(b){if(b.tagName=="DIV"&&!a.k(b,"u"))Q.push(b);else a.xc()&&a.C(b,(a.C(b)||0)+1)});var s=-1,wb,sb,r=Q.length,K=f.ig||nc,J=f.jg||lc,Vb=f.id,zb=K+Vb,Ab=J+Vb,Zb=eb&1?zb:Ab,u=b.min(f.W,r),jb,x,O,yb,T=[],Pb,Rb,Nb,ac,Bc,N,E=f.jd,kc=f.md,Ub=f.Kb,qb,tb,ib,Qb=u<r,D=Qb?f.Gb:0,X,P,F=1,M,B,S,ub=0,vb=0,H,gb,hb,Cb,w,U,z,Tb=new oc,Y,Kb=[];if(f.cb)Jb=function(b,c,d){a.Nc(b,{H:c,P:d})};N=f.ic;o.Qb=dc;gc();a.D(q,"jssor-slider",c);a.C(v,a.C(v)||0);a.F(v,"absolute");jb=a.rb(v,c);a.yb(jb,v);if(kb){ac=kb.ug;qb=kb.G;tb=u==1&&r>1&&qb&&(!a.kd()||a.Ac()>=8)}ib=tb||u>=r||!(D&1)?0:f.rd;X=(u>1||ib?eb:-1)&f.fd;var Gb=v,C=[],A,L,Db=a.eg(),mb=Db.hg,G,pb,Ib,rb;Db.qd&&a.Y(Gb,Db.qd,([i,"pan-y","pan-x","none"])[X]||"");U=new yc;if(tb)A=new qb(Tb,K,J,kb,mb);a.X(jb,U.Zb);a.Bb(v,"hidden");L=Wb();a.Y(L,"backgroundColor","#000");a.gc(L,0);a.yb(L,Gb.firstChild,Gb);for(var cb=0;cb<Q.length;cb++){var vc=Q[cb],xc=new wc(vc,cb);C.push(xc)}a.V(fb);Cb=new zc;z=new mc(Cb,U);if(X){a.a(v,"mousedown",Xb);a.a(v,"touchstart",qc);a.a(v,"dragstart",Hb);a.a(v,"selectstart",Hb);a.a(g,"mouseup",ab);a.a(g,"touchend",ab);a.a(g,"touchcancel",ab);a.a(e,"blur",ab)}E&=mb?10:5;if(Mb&&Fb){Pb=new Fb.G(Mb,Fb,W(),lb());T.push(Pb)}if(Z&&ec&&bc){Z.Gb=D;Z.W=u;Rb=new Z.G(ec,bc,Z,W(),lb());T.push(Rb)}if(Lb&&db){db.ac=f.ac;Nb=new db.G(Lb,db);T.push(Nb)}a.j(T,function(a){a.uc(r,C,fb);a.kb(n.tc,ic)});a.Y(q,"visibility","visible");Eb(W());a.a(v,"click",hc);a.a(q,"mouseout",a.nc(Ec,q));a.a(q,"mouseover",a.nc(Dc,q));xb();f.cc&&a.a(g,"keydown",function(a){if(a.keyCode==37)ob(-f.cc);else a.keyCode==39&&ob(f.cc)});var nb=f.ac;if(!(D&1))nb=b.max(0,b.min(nb,r-u));z.Nb(nb,nb,0)};h.le=21;h.de=22;h.qe=23;h.Ld=24;h.Kd=25;h.ke=26;h.Fd=27;h.zd=28;h.Md=202;h.lg=203;h.ce=206;h.fe=207;h.xd=208;h.zc=209;var n={tc:1},q=function(e,C){var f=this;m.call(f);e=a.ob(e);var s,A,z,r,l=0,d,o,k,w,x,h,g,q,p,B=[],y=[];function v(a){a!=-1&&y[a].be(a==l)}function t(a){f.l(n.tc,a*o)}f.I=e;f.sc=function(a){if(a!=r){var d=l,c=b.floor(a/o);l=c;r=a;v(d);v(c)}};f.fc=function(b){a.U(e,b)};var u;f.uc=function(D){if(!u){s=b.ceil(D/o);l=0;var n=q+w,r=p+x,m=b.ceil(s/k)-1;A=q+n*(!h?m:k-1);z=p+r*(h?m:k-1);a.m(e,A);a.n(e,z);for(var f=0;f<s;f++){var C=a.ng();a.re(C,f+1);var j=a.ae(g,"numbertemplate",C,c);a.F(j,"absolute");var v=f%(m+1);a.O(j,!h?n*v:f%k*n);a.N(j,h?r*v:b.floor(f/(m+1))*r);a.X(e,j);B[f]=j;d.lc&1&&a.a(j,"click",a.M(i,t,f));d.lc&2&&a.a(j,"mouseover",a.nc(a.M(i,t,f),j));y[f]=a.kc(j)}u=c}};f.Qb=d=a.L({bd:10,hd:10,Kc:1,lc:1},C);g=a.E(e,"prototype");q=a.m(g);p=a.n(g);a.Jb(g,e);o=d.Jc||1;k=d.cf||1;w=d.bd;x=d.hd;h=d.Kc-1;d.bf==j&&a.D(e,"noscale",c);d.gb&&a.D(e,"autocenter",d.gb)},r=function(b,g,h){var d=this;m.call(d);var r,q,e,f,k;a.m(b);a.n(b);function l(a){d.l(n.tc,a,c)}function p(c){a.U(b,c||!h.Gb&&e==0);a.U(g,c||!h.Gb&&e>=q-h.W);r=c}d.sc=function(b,a,c){if(c)e=a;else{e=b;p(r)}};d.fc=p;var o;d.uc=function(d){q=d;e=0;if(!o){a.a(b,"click",a.M(i,l,-k));a.a(g,"click",a.M(i,l,k));a.kc(b);a.kc(g);o=c}};d.Qb=f=a.L({Jc:1},h);k=f.Jc;if(f.bf==j){a.D(b,"noscale",c);a.D(g,"noscale",c)}if(f.gb){a.D(b,"autocenter",f.gb);a.D(g,"autocenter",f.gb)}};function p(e,d,c){var b=this;l.call(b,0,c);b.Lb=a.Ic;b.dc=0;b.Ub=c}var s=function(n,e,m){var b=this,o,h={},i=e.lb,d=new l(0,0);l.call(b,0,0);function j(d,c){var b={};a.j(d,function(d,f){var e=h[f];if(e){if(a.fg(d))d=j(d,c||f=="e");else if(c)if(a.Tb(d))d=o[d];b[e]=d}});return b}function k(e,c){var b=[],d=a.bb(e);a.j(d,function(d){var h=a.k(d,"u")=="caption";if(h){var e=a.k(d,"t"),g=i[a.Xb(e)]||i[e],f={I:d,Ob:g};b.push(f)}if(c<5)b=b.concat(k(d,c+1))});return b}function r(c,f,b){var g=e.cb&&a.k(c,"hwa");a.j(f,function(h){var e=j(h),f=a.Xc(e.ab);if(g){if(e.i){e.H=e.i;f.H=f.i;delete e.i}if(e.g){e.P=e.g;f.P=f.g;delete e.g}}var k={ab:f,bc:a.ge(),Q:b.qb,R:b.pb},i=new l(h.b,h.d,k,c,b,e);d.mb(i);b=a.he(b,e)});return b}function q(b){a.j(b,function(c){var b=c.I,e=a.m(b),d=a.n(b),f={i:a.O(b),g:a.N(b),J:1,wb:a.C(b)||0,A:0,vb:0,tb:0,v:1,z:1,H:0,P:0,db:0,Eb:0,Fb:0,qb:e,pb:d,f:{g:0,q:e,p:d,i:0}};r(b,c.Ob,f)})}function t(g,f,h){var e=g.b-f;if(e){var a=new l(f,e);a.mb(d,c);a.Sb(h);b.mb(a)}b.Dd(g.d);return e}function s(f){var c=d.qc(),e=0;a.j(f,function(d,f){d=a.L({d:m},d);t(d,c,e);c=d.b;e+=d.d;if(!f||d.t==2){b.dc=c;b.Ub=c+d.d}})}b.Lb=function(){b.B(-1,c)};o=[f.Pe,f.te,f.ue,f.ve,f.we,f.xe,f.ye,f.ze,f.Ae,f.Be,f.Ce,f.De,f.Tc,f.Ee,f.Fe,f.Ge,f.He,f.Ie,f.Je,f.We,f.Ve,f.Ue,f.Te,f.Se,f.Re,f.Xe,f.Qe,f.Oe,f.Ne,f.Me,f.Jf,f.Le,f.Ke,f.Ye,f.If,f.Uf,f.Kf];var u={g:"y",i:"x",p:"m",q:"t",A:"r",vb:"rX",tb:"rY",v:"sX",z:"sY",H:"tX",P:"tY",db:"tZ",Eb:"kX",Fb:"kY",J:"o",ab:"e",wb:"i",f:"c"};a.j(u,function(b,a){h[b]=a});q(k(n,1));d.B(-1);var p=e.yg||[],g=[].concat(p[a.Xb(a.k(n,"b"))]||[]);g.push({b:d.Mb(),d:g.length?0:m});s(g);b.B(-1)};jssor_1_slider_init=function(){var i=[[{b:5500,d:3e3,o:-1,r:240,e:{r:2}}],[{b:-1,d:1,o:-1,c:{x:51,t:-51}},{b:0,d:1e3,o:1,c:{x:-51,t:51},e:{o:7,c:{x:7,t:7}}}],[{b:-1,d:1,o:-1,sX:9,sY:9},{b:1e3,d:1e3,o:1,sX:-9,sY:-9,e:{sX:2,sY:2}}],[{b:-1,d:1,o:-1,r:-180,sX:9,sY:9},{b:2e3,d:1e3,o:1,r:180,sX:-9,sY:-9,e:{r:2,sX:2,sY:2}}],[{b:-1,d:1,o:-1},{b:3e3,d:2e3,y:180,o:1,e:{y:16}}],[{b:-1,d:1,o:-1,r:-150},{b:7500,d:1600,o:1,r:150,e:{r:3}}],[{b:1e4,d:2e3,x:-379,e:{x:7}}],[{b:1e4,d:2e3,x:-379,e:{x:7}}],[{b:-1,d:1,o:-1,r:288,sX:9,sY:9},{b:9100,d:900,x:-1400,y:-660,o:1,r:-288,sX:-9,sY:-9,e:{r:6}},{b:1e4,d:1600,x:-200,o:-1,e:{x:16}}]],j={ic:c,Kb:800,wc:f.Tc,mg:{G:s,lb:i},kg:{G:r},gg:{G:q}},g=new h("jssor_1",j);function d(){var a=g.I.parentNode.clientWidth;if(a){a=b.min(a,1920);g.Qf(a)}else e.setTimeout(d,30)}d();a.a(e,"load",d);a.a(e,"resize",a.ag(e,d));a.a(e,"orientationchange",d)}})(window,document,Math,null,true,false)
