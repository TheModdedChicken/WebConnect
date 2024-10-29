import * as universal from '../entries/pages/_layout.ts.js';

export const index = 0;
let component_cache;
export const component = async () => component_cache ??= (await import('../entries/pages/_layout.svelte.js')).default;
export { universal };
export const universal_id = "src/routes/+layout.ts";
export const imports = ["_app/immutable/nodes/0.BYrlfj1w.js","_app/immutable/chunks/disclose-version.B6Sji2Jz.js","_app/immutable/chunks/runtime.DgFCWXxz.js"];
export const stylesheets = ["_app/immutable/assets/0.BpAVHVrk.css"];
export const fonts = [];
