import{D as C,F as A,G as D,H as P,I as Y,B as V,J as E,x as B,K as W,L as $,M as T,N as g,A as I,C as j,w as h,O as q,P as z,Q as F,R as G,S as J,U as K,z as Q,m as U,p as X,v as S,i as Z,c as x,o as N,b as ee,V as re,W as te,g as se,X as ne}from"./runtime.DgFCWXxz.js";import{b as ae}from"./disclose-version.B6Sji2Jz.js";const ie=new Set,L=new Set;function y(e){var O;var r=this,n=r.ownerDocument,s=e.type,u=((O=e.composedPath)==null?void 0:O.call(e))||[],t=u[0]||e.target,c=0,b=e.__root;if(b){var d=u.indexOf(b);if(d!==-1&&(r===document||r===window)){e.__root=r;return}var l=u.indexOf(r);if(l===-1)return;d<=l&&(c=d)}if(t=u[c]||e.target,t!==r){C(e,"currentTarget",{configurable:!0,get(){return t||n}});var m=Y,o=V;A(null),D(null);try{for(var a,i=[];t!==null;){var f=t.assignedSlot||t.parentNode||t.host||null;try{var _=t["__"+s];if(_!==void 0&&!t.disabled)if(P(_)){var[M,...k]=_;M.apply(t,[e,...k])}else _.call(t,e)}catch(p){a?i.push(p):a=p}if(e.cancelBubble||f===r||f===null)break;t=f}if(a){for(let p of i)queueMicrotask(()=>{throw p});throw a}}finally{e.__root=r,delete e.currentTarget,A(m),D(o)}}}const ue=["touchstart","touchmove"];function oe(e){return ue.includes(e)}function _e(e,r){var n=r==null?"":typeof r=="object"?r+"":r;n!==(e.__t??(e.__t=e.nodeValue))&&(e.__t=n,e.nodeValue=n==null?"":n+"")}function fe(e,r){return H(e,r)}function be(e,r){E(),r.intro=r.intro??!1;const n=r.target,s=S,u=h;try{for(var t=B(n);t&&(t.nodeType!==8||t.data!==W);)t=$(t);if(!t)throw T;g(!0),I(t),j();const c=H(e,{...r,anchor:t});if(h===null||h.nodeType!==8||h.data!==q)throw z(),T;return g(!1),c}catch(c){if(c===T)return r.recover===!1&&F(),E(),G(n),g(!1),fe(e,r);throw c}finally{g(s),I(u)}}const v=new Map;function H(e,{target:r,anchor:n,props:s={},events:u,context:t,intro:c=!0}){E();var b=new Set,d=o=>{for(var a=0;a<o.length;a++){var i=o[a];if(!b.has(i)){b.add(i);var f=oe(i);r.addEventListener(i,y,{passive:f});var _=v.get(i);_===void 0?(document.addEventListener(i,y,{passive:f}),v.set(i,1)):v.set(i,_+1)}}};d(J(ie)),L.add(d);var l=void 0,m=K(()=>{var o=n??r.appendChild(Q());return U(()=>{if(t){X({});var a=x;a.c=t}u&&(s.$$events=u),S&&ae(o,null),l=e(o,s)||{},S&&(V.nodes_end=h),t&&Z()}),()=>{var f;for(var a of b){r.removeEventListener(a,y);var i=v.get(a);--i===0?(document.removeEventListener(a,y),v.delete(a)):v.set(a,i)}L.delete(d),R.delete(l),o!==n&&((f=o.parentNode)==null||f.removeChild(o))}});return R.set(l,m),l}let R=new WeakMap;function ve(e){const r=R.get(e);r&&r()}function ce(e,r,n){if(e==null)return r(void 0),N;const s=ee(()=>e.subscribe(r,n));return s.unsubscribe?()=>s.unsubscribe():s}let w=!1;function he(e,r,n){const s=n[r]??(n[r]={store:null,source:te(void 0),unsubscribe:N});if(s.store!==e)if(s.unsubscribe(),s.store=e??null,e==null)s.source.v=void 0,s.unsubscribe=N;else{var u=!0;s.unsubscribe=ce(e,t=>{u?s.source.v=t:ne(s.source,t)}),u=!1}return se(s.source)}function pe(){const e={};return re(()=>{for(var r in e)e[r].unsubscribe()}),e}function ge(e){var r=w;try{return w=!1,[e(),w]}finally{w=r}}export{_e as a,he as b,ge as c,be as h,fe as m,pe as s,ve as u};
