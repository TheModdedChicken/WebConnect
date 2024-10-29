import { E as pop, B as push } from "../../chunks/index.js";
function _layout($$payload, $$props) {
  push();
  let { children } = $$props;
  $$payload.out += `<head><title>{{BRANDING:TITLE}}</title></head> `;
  children($$payload);
  $$payload.out += `<!---->`;
  pop();
}
export {
  _layout as default
};
